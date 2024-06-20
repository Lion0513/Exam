//package chapter10;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServlet;
//
//public class HelloFilter implements Filter {
//
//	public void doFilter(
//			ServletResponse response, ServletRequest request,FilterChain chain)
//	throw IOException, ServletException{
//		PrintWriter out=response.getWriter();
//
//	out.println("[HelloFilter(pre)]");
//	chain.doFilter(request, response);
//	}
//	}
