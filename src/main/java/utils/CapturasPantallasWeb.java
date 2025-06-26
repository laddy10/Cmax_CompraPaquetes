package utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class CapturasPantallasWeb {

  private static final Logger logger = Logger.getLogger(CapturasPantallasWeb.class.getName());
  public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy HH_mm_ss");
  private static int contador = 1;
  private static final String RUTA_CAPTURAS = "Capturas/";
  private static final Map<String, String> titulosCapturas = new HashMap<>();

  public static String capturaPantalla(String nombreCaptura, String titulo) {
    String fecha = dtf.format(LocalDateTime.now());
    String nombreArchivo = nombreCaptura + "_" + contador + "_" + fecha + ".jpg";
    contador++;

    try {
      Robot robot = new Robot();
      Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
      BufferedImage image = robot.createScreenCapture(capture);

      // Crear una nueva imagen con espacio para el título
      BufferedImage imageWithText = new BufferedImage(image.getWidth(), image.getHeight() + 40, BufferedImage.TYPE_INT_RGB);
      Graphics2D g = imageWithText.createGraphics();
      g.setColor(Color.WHITE);
      g.fillRect(0, 0, imageWithText.getWidth(), imageWithText.getHeight());

      // Configurar la fuente
      Font font = new Font("Calibri", Font.ROMAN_BASELINE, 26);
      g.setFont(font);
      g.setColor(Color.BLACK);
      g.drawString(titulo, 10, 30);

      // Dibujar la imagen original
      g.drawImage(image, 0, 40, null);


      // Dibujar el borde rojo alrededor de la imagen
      g.setColor(Color.RED);
      g.setStroke(new BasicStroke(5)); // Grosor del borde
      g.drawRect(0, 40, image.getWidth() - 1, image.getHeight() - 1);
      g.dispose();


      // Guardar la imagen
      File output = new File(RUTA_CAPTURAS + nombreArchivo);
      ImageIO.write(imageWithText, "jpg", output);

      // Guardar el título asociado al archivo
      titulosCapturas.put(nombreArchivo, titulo);

      logger.info("Captura guardada: " + nombreArchivo);
      return nombreArchivo;
    } catch (Exception e) {
      logger.severe("Error al capturar pantalla: " + e.getMessage());
      return null;
    }
  }

  public static String obtenerTitulo(String nombreArchivo) {
    return titulosCapturas.getOrDefault(nombreArchivo, "Sin título");
  }
}
