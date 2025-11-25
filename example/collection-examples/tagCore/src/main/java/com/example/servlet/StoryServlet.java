package com.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.time.Month;
import java.time.MonthDay;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

@WebServlet(name = "StoryServlet", urlPatterns = "/list")
public class StoryServlet extends HttpServlet {

    private static final SortedSet<Story> STORIES = new TreeSet<>() {{
        add(new Story("News1", "Basketball is very popular", "Ivanov", "Sport",
                MonthDay.of(Month.JULY, 14),
                Instant.parse("2018-07-15T08:13:45Z")));

        add(new Story("News2", "How to cook fish", null, "Food",
                MonthDay.of(Month.JULY, 13),
                Instant.parse("2018-07-16T08:17:45Z")));

        add(new Story("News3", "New president elected", "Petrov", "Politics",
                MonthDay.of(Month.JULY, 15),
                Instant.parse("2018-07-15T08:45:45Z")));
    }};

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("empty") != null) {
            request.setAttribute("stories", Collections.<Story>emptySet());
        } else {
            request.setAttribute("stories", STORIES);
        }

        request.getRequestDispatcher("/WEB-INF/jsp/list.jsp")
                .forward(request, response);
    }
}