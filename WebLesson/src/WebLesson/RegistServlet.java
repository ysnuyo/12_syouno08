package WebLesson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegistServlet extends HttpServlet {
	protected void service(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");

		String eng =req.getParameter("eng");
		String jp = req.getParameter("jp");

		List <Word> word = new ArrayList <Word>();

		int arrayresult;

		WordDAO worddao = new WordDAO();


		word.add(new Word(eng,jp));

		arrayresult = worddao.registWords(word);//登録

		word.clear();

		word = worddao.getWords();

		req.setAttribute("arrayresult",arrayresult);
		req.setAttribute("size",word.size());

		req.getRequestDispatcher("result.jsp").forward(req,res);
	}
}