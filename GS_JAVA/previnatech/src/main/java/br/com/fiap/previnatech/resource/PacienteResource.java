package br.com.fiap.previnatech.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

import br.com.fiap.previnatech.model.Paciente;
import br.com.fiap.previnatech.service.PacienteService;

@Path("paciente")
public class PacienteResource {
    private final PacienteService pacienteService;

    public PacienteResource() {
        this.pacienteService = new PacienteService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFuncionarios() {
        ArrayList<Paciente> pacientes = pacienteService.listaDePacientes();

        if (pacientes != null) {
            return Response.ok(pacientes).build();
        } else {
        	return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getPacientePorId(@PathParam("id") long pacienteId) {
        Paciente paciente = pacienteService.obterPacientePorId(pacienteId);

        if (paciente != null) {
            return Response.ok(paciente).build();
        } else {
        	return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletePacientePorId(@PathParam("id") long pacienteId) {
        boolean deleted = pacienteService.deletarPaciente(pacienteId);

        if (deleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response novoPaciente(Paciente paciente) {
        boolean created = pacienteService.novoPaciente(paciente);

        if (created) {
            return Response.status(Response.Status.CREATED).build();
        } else {
        	return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response atualizarPaciente(@PathParam("id") long pacienteId, Paciente paciente) {
        boolean updated = pacienteService.atualizarPaciente(pacienteId, paciente);

        if (updated) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
