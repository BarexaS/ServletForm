package scrforanket;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


@WebServlet(name = "FirstFormServlet", urlPatterns = "/Statistics")
public class FirstFormServlet extends javax.servlet.http.HttpServlet {

    private static AtomicInteger answerTotal = new AtomicInteger();
    private static AtomicInteger quest1Yes = new AtomicInteger();
    private static AtomicInteger quest2Yes = new AtomicInteger();
    private static AtomicInteger quest3Yes = new AtomicInteger();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        answerTotal.incrementAndGet();

        Map<String, String[]> answers = request.getParameterMap();

        if ("yes".equals(answers.get("quest1")[0])) {
            quest1Yes.incrementAndGet();
        }
        if ("yes".equals(answers.get("quest2")[0])) {
            quest2Yes.incrementAndGet();
        }
        if ("yes".equals(answers.get("quest3")[0])) {
            quest3Yes.incrementAndGet();
        }


        String template = TemplateLoader.loadTemplate(request.getSession().getServletContext().getRealPath("TemplateStatistics.html"));


        response.getWriter().print(String.format(template, answerTotal.get(), quest1Yes.get(), (answerTotal.get() - quest1Yes.get()),
                quest2Yes.get(), (answerTotal.get() - quest2Yes.get()),
                quest3Yes.get(), (answerTotal.get() - quest3Yes.get())));
    }
}
