package vn.week2_lab2_doanhoaian_20116041.resources;

import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import vn.week2_lab2_doanhoaian_20116041.models.Employee;
import vn.week2_lab2_doanhoaian_20116041.services.EmplooyeService;

import java.util.Optional;

@Path("/employees")
public class EmployeResouce {
    private static final int aplication = 0;
    private EmplooyeService emplooyeService;

    public EmployeResouce() {
        emplooyeService = new EmplooyeService();
    }

   
    @GET
    @Path("/{id}")
    @Produces(aplication/json)
    public Response getEmployeeById(@PathParam("id") long id) {
        Optional<Employee> employee = emplooyeService.findById(id);
        if (employee.isPresent()) {
            return Response.ok(employee.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
   

}
