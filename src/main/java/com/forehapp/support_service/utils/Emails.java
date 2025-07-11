package com.forehapp.support_service.utils;

public class Emails {

    public static String supportTicketEmail(String name, String email, String message) {
        StringBuilder emailBody = new StringBuilder();

        emailBody.append("<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c;background-color:#f4f4f4;padding:20px;\">")
                .append("  <div style=\"max-width:600px;margin:20px auto;padding:20px;border-radius:8px;box-shadow:0px 4px 8px rgba(0, 0, 0, 0.1);background-color:#ffffff;\">")

                .append("    <h2 style=\"color:#418622;text-align:center;\">🆘 Nuevo mensaje de soporte</h2>")

                .append("    <p style=\"color:#333;\">Has recibido un nuevo mensaje de soporte a través de la app <strong>Forehapp</strong>.</p>")

                .append("    <p style=\"color:#333;\"><strong>Nombre:</strong> ").append(name != null ? name : "No especificado").append("</p>")
                .append("    <p style=\"color:#333;\"><strong>Correo:</strong> ").append(email != null ? email : "No especificado").append("</p>")

                .append("    <hr style=\"margin:20px 0;\">")
                .append("    <p style=\"color:#333;\"><strong>Mensaje:</strong></p>")
                .append("    <blockquote style=\"border-left:4px solid #418622;padding-left:12px;color:#555;\">")
                .append(message != null ? message.replace("\n", "<br>") : "Mensaje vacío")
                .append("</blockquote>")

                .append("    <p style=\"color:#888;font-size:13px;margin-top:30px;text-align:center;\">Este mensaje fue enviado desde el módulo de soporte de Forehapp.</p>")
                .append("  </div>")
                .append("</div>");

        return emailBody.toString();
    }
}

