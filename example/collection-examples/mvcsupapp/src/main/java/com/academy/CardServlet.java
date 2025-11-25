package com.academy;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(name = "CardServlet", urlPatterns = {"/cards"}, loadOnStartup = 1)
@MultipartConfig(
        fileSizeThreshold = 5_242_880,
        maxFileSize = 20_971_520L,
        maxRequestSize = 41_943_040L
)
public class CardServlet extends HttpServlet {

    private final Map<Integer, Card> cardBase = new LinkedHashMap<>();
    private volatile int CARD_ID = 1;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "create" -> showCardForm(request, response);
            case "view" -> viewCard(request, response);
            case "download" -> downloadAttachment(request, response);
            default -> listCards(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if ("create".equals(action)) {
            createCard(request, response);
        } else {
            response.sendRedirect("cards");
        }
    }



    private void showCardForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/view/cardForm.jsp")
                .forward(request, response);
    }

    private void createCard(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Card card = new Card();
        card.setClientName(request.getParameter("clientName"));
        card.setTopic(request.getParameter("topic"));
        card.setMessage(request.getParameter("message"));


        Part filePart = request.getPart("file1");
        if (filePart != null && filePart.getSize() > 0) {
            Attachment attachment = processAttachment(filePart);
            if (attachment != null) {
                card.addAttachment(attachment);
            }
        }

        int id;
        synchronized (this) {
            id = CARD_ID++;
            cardBase.put(id, card);
        }

        response.sendRedirect("cards?action=view&cardId=" + id);
    }

    private void viewCard(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("cardId");
        Card card = getCard(idStr, response);
        if (card == null) return;

        request.setAttribute("cardId", idStr);
        request.setAttribute("card", card);
        request.getRequestDispatcher("/WEB-INF/jsp/view/viewCard.jsp")
                .forward(request, response);
    }

    private void listCards(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("cardBase", cardBase);
        request.getRequestDispatcher("/WEB-INF/jsp/view/listCards.jsp")
                .forward(request, response);
    }



    private Attachment processAttachment(Part filePart) throws IOException {
        InputStream inputStream = filePart.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        Attachment attachment = new Attachment();
        attachment.setFileName(getSubmittedFileName(filePart));
        attachment.setFileContents(outputStream.toByteArray());
        return attachment;
    }


    private String getSubmittedFileName(Part part) {
        String header = part.getHeader("content-disposition");
        if (header == null) return "unknown_file";
        for (String partHeader : header.split(";")) {
            if (partHeader.trim().startsWith("filename")) {
                String fileName = partHeader.substring(partHeader.indexOf('=') + 1).trim();
                fileName = fileName.replace("\"", "");
                return fileName.isEmpty() ? "unknown_file" : fileName;
            }
        }
        return "unknown_file";
    }

    private void downloadAttachment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("cardId");
        Card card = getCard(idStr, response);
        if (card == null) return;

        String fileName = request.getParameter("attachment");
        if (fileName == null || fileName.isEmpty()) {
            response.sendRedirect("cards?action=view&cardId=" + idStr);
            return;
        }

        Attachment attachment = card.getAttachment(fileName);
        if (attachment == null) {
            response.sendRedirect("cards?action=view&cardId=" + idStr);
            return;
        }

        response.setHeader("Content-Disposition", "attachment; filename=\"" + attachment.getFileName() + "\"");
        response.setContentType("application/octet-stream");

        try (ServletOutputStream out = response.getOutputStream()) {
            out.write(attachment.getFileContents());
        }
    }



    private Card getCard(String idStr, HttpServletResponse response) throws IOException {
        if (idStr == null || idStr.isEmpty()) {
            response.sendRedirect("cards");
            return null;
        }
        try {
            int id = Integer.parseInt(idStr);
            Card card = cardBase.get(id);
            if (card == null) {
                response.sendRedirect("cards");
                return null;
            }
            return card;
        } catch (NumberFormatException e) {
            response.sendRedirect("cards");
            return null;
        }
    }
}