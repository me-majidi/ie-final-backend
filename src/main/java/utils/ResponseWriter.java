package utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ResponseWriter {
    public static void write(HttpServletResponse res, String responseText) {
        try {
//            OutputStreamWriter out = new OutputStreamWriter(res.getOutputStream());
//            out.write(responseText);
//            out.flush();
            res.getWriter().write(responseText);
        } catch (IOException e) {}
    }
}
