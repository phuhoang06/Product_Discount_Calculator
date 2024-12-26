package com.example.productdiscountcalculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

@WebServlet(name = "DiscountServlet", urlPatterns = "/discount")
public class DiscountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float listprice = Float.parseFloat(req.getParameter("list-price"));
        float discount = Float.parseFloat(req.getParameter("discount-percent"));
        float discountAmount = listprice * discount / 100;
        float discountPrice = listprice - discountAmount;

        PrintWriter writer = resp.getWriter();
        writer.println("Product Description:" + req.getParameter("product-description"));
        writer.println("Discount Amount: " + discountAmount );
        writer.println("Discount Price: " + discountPrice );

    }
}