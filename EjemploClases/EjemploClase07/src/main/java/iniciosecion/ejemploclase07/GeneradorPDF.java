/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iniciosecion.ejemploclase07;
import com.itextpdf.io.image.ImageDataFactory; // imagen
import com.itextpdf.kernel.pdf.PdfDocument; //
import com.itextpdf.kernel.pdf.PdfWriter; // Escribir el pdf
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
/**
 *
 * @author Pacos
 */
public class GeneradorPDF {
    public void generarPDF(String destino, String [] encabezado, String [][] data, String rutaImagen, String texto1, String texto2) throws FileNotFoundException, IOException, MalformedURLException {
        // Crear Documento en PDF
        PdfWriter writter = new PdfWriter(destino);
        PdfDocument pdf = new PdfDocument(writter);
        Document documento = new Document(pdf);
        
        // Primera página (imagen)
        this.primeraPagina(documento, rutaImagen);
        
        // Segunda página (tablas, titulo, texto, imagen)
        this.segundaPagina(documento, rutaImagen, "Tabla 2", encabezado, data, texto1, texto2);
        
        documento.close();
    }
    
    private void primeraPagina(Document documento, String ruta) throws MalformedURLException {
        // Agregaremos una imagen
        // se usará el path de la imagen y se obtendrá
        Image imagen = new Image(ImageDataFactory.create(ruta))
                .setHorizontalAlignment(HorizontalAlignment.CENTER)
                .setAutoScale(true);
        
        documento.add(imagen);
    }
    
    private void segundaPagina(Document documento, String ruta, String titulo, String [] encabezado, String [][] datos, String texto1, String texto2) throws MalformedURLException {
        documento.add(new AreaBreak()); // agregamos una nueva página (en esta se va a trabajar ahora)
        
        // Titulo
        documento.add(new Paragraph(titulo) // se agrega un parrafo
        .setTextAlignment(TextAlignment.CENTER) // alinearlo horizontalmente
        .setFontSize(22)); // tamaño letra
        
        // Texto 
        documento.add(new Paragraph(texto1)
        .setTextAlignment(TextAlignment.JUSTIFIED));
        
        // Tabla
        Table tabla1 = this.crearTabla(encabezado, datos);
        documento.add(tabla1);
        
        // Texto
        documento.add(new Paragraph("")
        .setTextAlignment(TextAlignment.JUSTIFIED));
        
        // Imagen
        Image imagen = new Image(ImageDataFactory.create(ruta))
                .setHorizontalAlignment(HorizontalAlignment.CENTER)
                .setWidth(100);
        documento.add(imagen);
        
        /// -------------- Segunda tabla, imagen
        // Texto 
        documento.add(new Paragraph(texto2)
        .setTextAlignment(TextAlignment.JUSTIFIED));
        
        // Tabla
        Table tabla2 = this.crearTabla(encabezado, datos);
        documento.add(tabla2);
        
        // Texto
        documento.add(new Paragraph("")
        .setTextAlignment(TextAlignment.JUSTIFIED));
        
        // Imagen
        Image imagen2 = new Image(ImageDataFactory.create(ruta))
                .setHorizontalAlignment(HorizontalAlignment.CENTER)
                .setWidth(100);
        documento.add(imagen2);
    }
    
    private Table crearTabla(String[] encabezado, String[][] data) {
        Table tabla = new Table(UnitValue.createPercentArray(encabezado.length)).useAllAvailableWidth();
        
        for (String valor : encabezado) {
            tabla.addHeaderCell(new Cell().add(new Paragraph(valor)));
        }
        
        for (String [] valor : data) {
            for (String celda : valor) {
                tabla.addCell(new Cell().add(new Paragraph(celda)));
            }
        }
        
        return tabla; //retornamos la tabla creada
    }
}
