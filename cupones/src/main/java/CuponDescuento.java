

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cupones.AddTextWatermark;
import cupones.DatosCupon;

/**
 * Servlet implementation class CuponDescuento
 */
@WebServlet("/CuponDescuento")
public class CuponDescuento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CuponDescuento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			InputStream is = CuponDescuento.class.getResourceAsStream("star_wars_episodio_ix.jpg");
			OutputStream os = response.getOutputStream();
			if (is == null) {
                response.setContentType("text/plain");
                os.write("Failed to send image".getBytes());
			} else {
				try
		        {
			        HttpSession sesion = request.getSession();
			        DatosCupon dc = (DatosCupon)sesion.getAttribute("dc");
			        BufferedImage image = ImageIO.read(is);
			        // determine image type and handle correct transparency
			        int imageType = BufferedImage.TYPE_INT_RGB;
			        BufferedImage watermarked = new BufferedImage(image.getWidth(), image.getHeight(), imageType);
			        ArrayList<String> titles = new ArrayList<String>();
		            titles.add(String.format("Cupón válido para"));
		            titles.add(String.format(
		            		"el día: %s",
			        		dc.getDate()
			    		));
			        int y = 0;
			        BufferedImage output = AddTextWatermark.addTextWatermark(
			        		titles,
			        		Color.CYAN,
			        		"jpg",
			        		image,
			        		y,
			        		40);
			        y = AddTextWatermark.calculateHeight(titles, watermarked);
			        titles.removeAll(titles);
		            titles.add(
	            		String.format(
			        		"%s",
			        		dc.getSala()
			    		));
			        y += AddTextWatermark.calculateHeight(titles, watermarked);
			        output = AddTextWatermark.addTextWatermark(
			        		titles,
			        		Color.ORANGE,
			        		"jpg",
			        		output,
			        		y,
			        		40);
			        titles.removeAll(titles);
		            titles.add(
		            		String.format(
	    		        		"%s %s",
	    		        		dc.getNames(),
	    		        		dc.getSurnames()
				    		));
		            titles.add(
		            		String.format(
	    		        		"DNI %s",
	    		        		dc.getDni()
				    		));
			        y = ((int)watermarked.getHeight()) - AddTextWatermark.calculateHeight(titles, watermarked);
			        output = AddTextWatermark.addTextWatermark(
			        		titles,
			        		Color.YELLOW,
			        		"jpg",
			        		output,
			        		y,
			        		36);
					response.setHeader( "Content-Type", "image/jpg" );
		    	    ImageIO.write(output, "jpg", os);
		    	    os.close();
		        } 
		        catch (IOException e) 
		        {
		            e.printStackTrace();
		        }
			}
	}

}
