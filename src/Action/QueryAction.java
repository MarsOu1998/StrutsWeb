package Action;

import Bean.Student;
import DAO.StudentDAO;
import Other.PageControllor;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import sun.jvm.hotspot.debugger.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class QueryAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String pageIndex=request.getParameter("PageIndex");
        if(pageIndex==null){
            pageIndex="1";
        }
        int currentPageIndex=Integer.parseInt(pageIndex);

        PageControllor pc=(PageControllor)request.getAttribute("pc");

        StudentDAO studentDAO=new StudentDAO();

        if(pc==null){
            pc=new PageControllor();
            ArrayList student=new ArrayList();
            student=studentDAO.getAllStu();
            pc.setBigList(student);
            request.setAttribute("pc",pc);
        }

        pc.setCurrentPageIndex(currentPageIndex);

        return new ActionForward("/display.jsp");
    }
}
