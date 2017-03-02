package br.ucb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProfitServlet
 */
@WebServlet("/ProfitServlet")
public class ProfitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String buyPriceFromHTML = request.getParameter("buy_price");
		
		try{
			float buyPriceFloat = Float.parseFloat(buyPriceFromHTML);
			out.println("O valor mínimo para obter 30% de lucro deve ser: R$" + formatForDisplay(calculateSellPrice(buyPriceFloat)));
		} catch(NumberFormatException nfe){
			out.println("O valor informado não pode ser processado. Por favor utilize apenas números.");
		}
	}
	
	private float calculateSellPrice(float buyPriceFloat){
		
		return (float) (buyPriceFloat*1.3); 
	}
	
	private String formatForDisplay(float numberToFormat){
		DecimalFormat decimalFormat = new DecimalFormat();
		decimalFormat.setMaximumFractionDigits(2);
		String formarttedNumber = decimalFormat.format(numberToFormat);
		
		return formarttedNumber;
	}

}
