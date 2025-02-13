Algoritmo Mantenimiento
	Escribir "Computadora Esta sucia? (si/no)"
	Leer ComputadoraSucia
	limpieza = ""
	Si ComputadoraSucia = "si" Entonces
		Escribir "Abrir Computadora"
		Escribir "Tiene polvo dentro"
		Leer Suciedad
		Si Suciedad == "si" Entonces
			Escribir "Se usa aire comprimido"
		SiNo
			Escribir "Cerrar computadora"
		FinSi
	Fin Si
	Escribir "Pantalla sucia? (si/no)"
	Leer PantallaSucia
	Si PantallaSucia == "si" Entonces
		Escribir "Limpieza con espuma"
		//aqui se puede extender (verificar si hay espuma)
	FinSi
	Escribir "Teclado sucio? (si/no)"
	Leer TecladoSucio
	Si TecladoSucio == "si" Entonces
		Escribir "Usar aire comprimido"
	FinSi
FinAlgoritmo
