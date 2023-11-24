package br.com.fiap.previnatech.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

import br.com.fiap.previnatech.model.Hospital;
import br.com.fiap.previnatech.service.HospitalService;

@Path("hospital")
public class HospitalResource {
    private final HospitalService hospitalService;

    public HospitalResource() {
        this.hospitalService = new HospitalService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHospitais() {
        ArrayList<Hospital> hospitais = hospitalService.listaDeHospitais();

        if (hospitais != null) {
            return Response.ok(hospitais).build();
        } else {
        	return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getHospitalPorId(@PathParam("id") long hospitalId) {
        Hospital hospital = hospitalService.obterHospitalPorId(hospitalId);

        if (hospital != null) {
            return Response.ok(hospital).build();
        } else {
        	return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteHospitalPorId(@PathParam("id") long hospitalId) {
        boolean deleted = hospitalService.deletarHospital(hospitalId);

        if (deleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response novoHospital(Hospital hospital) {
        boolean created = hospitalService.novoHospital(hospital);

        if (created) {
            return Response.status(Response.Status.CREATED).build();
        } else {
        	return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response atualizarHospital(@PathParam("id") long hospitalId, Hospital hospital) {
        boolean updated = hospitalService.atualizarHospital(hospitalId, hospital);

        if (updated) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
