/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iniciosecion.pruebapdf;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 *
 * @author Pacos
 */
public class GeneradorPDF {
    public void generarPDF(String dest, String[] encabezados, String[][] datos, String rutaImagen, String texto1, String texto2) throws FileNotFoundException, MalformedURLException, IOException {
        // Crear el documento PDF
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        // Primera página: Solo imagen
        agregarPaginaImagen(document, rutaImagen);

        // Segunda página: Título, tabla e imagen pequeña
        agregarPaginaTabla(document, "Segunda Página", encabezados, datos, rutaImagen);

        // Tercera página: Título, texto, tabla, imagen, texto, tabla, imagen
        agregarPaginaCompleja(document, "Tercera Página", encabezados, datos, rutaImagen, texto1, texto2);

        // Cerrar el documento
        document.close();
    }

    private void agregarPaginaImagen(Document document, String rutaImagen) throws MalformedURLException {
        Image imagen = new Image(ImageDataFactory.create(rutaImagen))
                .setHorizontalAlignment(HorizontalAlignment.CENTER)
                .setAutoScale(true);
        document.add(imagen);
    }

    private void agregarPaginaTabla(Document document, String titulo, String[] encabezados, String[][] datos, String rutaImagen) throws MalformedURLException {
        document.add(new AreaBreak());

        // Título
        document.add(new Paragraph(titulo)
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(18));

        // Tabla
        Table tabla = crearTabla(encabezados, datos);
        document.add(tabla);

        // Imagen
        Image imagen = new Image(ImageDataFactory.create(rutaImagen))
                .setHorizontalAlignment(HorizontalAlignment.CENTER)
                .setWidth(100);
        document.add(imagen);
    }
    
    private void agregarPaginaCompleja(Document document, String titulo, String[] encabezados, String[][] datos, String rutaImagen, String texto1, String texto2) throws MalformedURLException {
        document.add(new AreaBreak());

        // Título
        document.add(new Paragraph(titulo)
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(18));

        // Texto
        document.add(new Paragraph(texto1)
                .setTextAlignment(TextAlignment.JUSTIFIED));

        // Tabla
        Table tabla1 = crearTabla(encabezados, datos);
        document.add(tabla1);

        // Imagen
        Image imagen1 = new Image(ImageDataFactory.create(rutaImagen))
                .setHorizontalAlignment(HorizontalAlignment.CENTER)
                .setWidth(100);
        document.add(imagen1);

        
        document.add(new Paragraph(texto2)
                .setTextAlignment(TextAlignment.JUSTIFIED));

        Table tabla2 = crearTabla(encabezados, datos);
        document.add(tabla2);

        Image imagen2 = new Image(ImageDataFactory.create(rutaImagen))
                .setHorizontalAlignment(HorizontalAlignment.CENTER)
                .setWidth(100);
        document.add(imagen2);
    }

    private Table crearTabla(String[] encabezados, String[][] datos) {
        Table tabla = new Table(UnitValue.createPercentArray(encabezados.length)).useAllAvailableWidth();

        for (String encabezado : encabezados) {
            tabla.addHeaderCell(new Cell().add(new Paragraph(encabezado)));
        }

        for (String[] fila : datos) {
            for (String celda : fila) {
                tabla.addCell(new Cell().add(new Paragraph(celda)));
            }
        }

        return tabla;
    }
}
