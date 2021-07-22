package pastryshop.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pastryshop.dao.PhotoControlDao;
import pastryshop.dao.ProdottoDao;

/**
 * Servlet implementation class GetPictureServlet
 */
@WebServlet("/GetPictureServlet")
public class GetPictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static boolean isDataSource = true;
	
	static PhotoControlDao model;
	
	static {
		if (isDataSource) {
			model = new PhotoControlDao();
		}
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPictureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getParameter("id");
		if(id != null) {
			byte[] bt = null;
			try {
				bt = model.load(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ServletOutputStream out = response.getOutputStream();
			if(bt != null) {
				out.write(bt);
				response.setContentType("image/jpg");
			}
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
