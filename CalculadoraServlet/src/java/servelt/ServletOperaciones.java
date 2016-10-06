/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelt;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ServletOperaciones extends HttpServlet {
    int num1, num2;
    String op;
    @Override
    public void doPost(HttpServletRequest pet, HttpServletResponse res)
            throws ServletException, IOException{
        op = pet.getParameter("operacion");
        num1 = Integer.parseInt(pet.getParameter("number1"));
        num2 = Integer.parseInt(pet.getParameter("number2"));
        int resp = 0;
        String ope = " ";
        if(op.equals("+")){
            resp = num1+num2;
            ope = "la suma";
        } else {
            if(op.equals("-")){
                resp = num1-num2;
                ope = "la resta";
            } else {
                if(op.equals("X")){
                    resp = num1*num2;
                    ope = "la multiplicacion";
                } else {
                    if(op.equals("/")){
                        resp = num1/num2;
                        ope = "la division";
                    } else {
                        if(op.equals("mod")){
                            resp = num1%num2;
                            ope = "el modulo";
                        }
                    }
                }
            }
        }
        
        PrintWriter out = new PrintWriter(res.getOutputStream());
        
        out.println("<html>");
        out.println("<body>");
        out.println("<div>");
        out.println("<center><h1> El resultado de "+ope+" es: "+ resp +"</h1></center>");
        out.println("</div></body></html>");        
        out.close();
    }
    
}
