package br.usjt.ccp3an_mca_projeto_integrado.controller;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)
            throws Exception {
        //HttpSession session = request.getSession();
        //if(session.getAttribute("usuarioLogado") == null) response.sendRedirect("/login");
        return true;
    }
}
