package com.githrd.blpink.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public interface BlpInter {
	String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
