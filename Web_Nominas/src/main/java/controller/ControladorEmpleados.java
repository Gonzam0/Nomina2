package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpleadoDao;
import laboral.DatosNoCorrectosException;
import model.Empleado;
import model.Nomina;

/**
 * Servlet implementation class ControlladorEmpleados
 */
@WebServlet("/ControladorEmpleados")
public class ControladorEmpleados extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControladorEmpleados() {
		super();
	}

	/**
	 * Maneja las solicitudes GET para mostrar empleados o nóminas.
	 *
	 * @param request  La solicitud HTTP recibida.
	 * @param response La respuesta HTTP que se enviará al cliente.
	 * @throws ServletException Si se produce un error en el servlet.
	 * @throws IOException      Si se produce un error de E/S.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opcion = request.getParameter("opcion");

		if (opcion.equals("mostrarEmp")) {
			// Llama al método para mostrar todos empleado
			EmpleadoDao empleadoDAO = new EmpleadoDao();
			List<Empleado> empleados = new ArrayList<>();
			try {
				empleados = empleadoDAO.obtenerEmpleados();

				request.setAttribute("empleados", empleados);

				request.setAttribute("content", "/views/mostrarEmp.jsp");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/singleView.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException | DatosNoCorrectosException e) {
				e.printStackTrace();
			}
			System.out.println("Usted a presionado la opcion mostrar empleado");

		} else if (opcion.equals("editarEmp")) {
			// Llama al método para editar un empleado
			EmpleadoDao empleadoDAO = new EmpleadoDao();
			List<Empleado> empleados = new ArrayList<>();
			try {
				empleados = empleadoDAO.obtenerEmpleados();

				request.setAttribute("empleados", empleados);
				request.setAttribute("content", "/views/editarEmp.jsp");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/singleView.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException | DatosNoCorrectosException e) {
				e.printStackTrace();
			}
			System.out.println("Usted a presionado la opcion editar empleado");

		} else if (opcion.equals("mostrarNom")) {

			try {
				// Llama al método para obtener el sueldo del empleado
				String dni = request.getParameter("dni");
				EmpleadoDao empDAO = new EmpleadoDao();
				Nomina empleado = empDAO.obtenerSueldo(dni);

				if (empleado != null) {
					List<Nomina> empleados = new ArrayList<>();
					empleados.add(empleado);

					request.setAttribute("empleados", empleados);
					request.setAttribute("content", "/views/mostrarNom.jsp");
				} else {
					request.setAttribute("empleados", new ArrayList<Empleado>());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/views/singleView.jsp").forward(request, response);
			System.out.println("Usted a presionado la opcion mostrar nómina");

		} else if (opcion.equals("crearEmp")) {

			System.out.println("Usted a presionado la opcion crear empleado");

			request.setAttribute("content", "/views/crearEmp.jsp");
			request.getRequestDispatcher("/views/singleView.jsp").forward(request, response);
		}
	}

	/**
	 * Maneja las solicitudes POST para mostrar nóminas.
	 *
	 * @param request  La solicitud HTTP recibida.
	 * @param response La respuesta HTTP que se enviará al cliente.
	 * @throws ServletException Si se produce un error en el servlet.
	 * @throws IOException      Si se produce un error de E/S.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opcion = request.getParameter("opcion");

		if (opcion.equals("mostrarNom")) {
			// Llama al método para obtener el sueldo del empleado del DNI
			String dni = request.getParameter("dni");

			if (dni != null && dni.length() >= 9) {
				EmpleadoDao empDAO = new EmpleadoDao();
				Nomina empleado = new Nomina();

				try {
					empleado = empDAO.obtenerSueldo(dni);

					List<Nomina> empleados = new ArrayList<Nomina>();
					empleados.add(empleado);

					request.setAttribute("empleados", empleados);
					request.setAttribute("content", "/views/mostrarNom.jsp");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				// Aquí puedes manejar el caso en el que el DNI esté vacío o tenga menos de 9
				// caracteres
				String errorMensaje = "DNI no válido.";
				request.setAttribute("errorMensaje", errorMensaje);
				request.setAttribute("content", "/views/mostrarNom.jsp");
			}

			request.getRequestDispatcher("/views/singleView.jsp").forward(request, response);
		} else if (opcion.equals("guardarEmp")) {

			try {
				EmpleadoDao empleadoDao = new EmpleadoDao();
				Empleado empleado = new Empleado();

				empleado.setNombre(request.getParameter("nombre"));
				empleado.setDni(request.getParameter("dni"));
				empleado.setSexo(request.getParameter("sexo"));
				empleado.setCategoria(Integer.parseInt(request.getParameter("categoria")));
				empleado.setAnyos(Integer.parseInt(request.getParameter("anyos")));
				try {
					empleadoDao.guardar(empleado);
					System.out.println("Empleado creado correctamente");

					// Establece el mensaje de éxito
					request.setAttribute("mensaje", "Empleado creado correctamente");

					// Redirige a la página de éxito
					request.setAttribute("content", "/views/crearEmp.jsp");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/singleView.jsp");
					requestDispatcher.forward(request, response);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		} else if (opcion.equals("editar")) {
			try {
				EmpleadoDao empleadoDao = new EmpleadoDao();
				Empleado empleado = new Empleado();
				empleado.setDni(request.getParameter("dni"));
				empleado.setNombre(request.getParameter("nombre"));
				empleado.setSexo(request.getParameter("sexo"));
				empleado.setCategoria(Integer.parseInt(request.getParameter("categoria")));
				empleado.setAnyos(Integer.parseInt(request.getParameter("anyos")));
				try {
					empleadoDao.editar(empleado);
					System.out.println("Empleado editado correctamente");
					request.setAttribute("mensaje", "Empleado editado correctamente");
					request.setAttribute("content", "/views/editarEmp.jsp");

					// Obt la lista actualizada de empleados
					List<Empleado> empleados = empleadoDao.obtenerEmpleados();

					// Coloca la lista en el atributo de la solicitud

					request.setAttribute("empleados", empleados);

					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/singleView.jsp");
					requestDispatcher.forward(request, response);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (opcion.equals("filtrarPorDni")) {
			// Obtener el parámetro del formulario
			String dni = request.getParameter("dni");

			if (dni != null && dni.length() >= 9) {

				// Llama al método para filtrar empleados por DNI
				EmpleadoDao empleadoDAO = new EmpleadoDao();
				List<Empleado> empleados = new ArrayList<>();
				try {
					empleados = empleadoDAO.filtrarDni(dni);
					request.setAttribute("empleados", empleados);
					request.setAttribute("content", "/views/editarEmp.jsp");
				} catch (SQLException | DatosNoCorrectosException e) {
					e.printStackTrace();
				}

			} else {
				String errorMensaje = "DNI no válido.";
				request.setAttribute("errorMensaje", errorMensaje);
				request.setAttribute("content", "/views/editarEmp.jsp");
			}

			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/singleView.jsp");
			requestDispatcher.forward(request, response);
			System.out.println("Usted a presionado la opción filtrar empleados por DNI");
		}
	}
}