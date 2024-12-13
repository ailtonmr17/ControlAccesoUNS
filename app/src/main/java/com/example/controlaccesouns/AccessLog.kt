data class AccessLog(
    val id: String,
    val docente: String,
    val laboratorio: String,
    val curso: String,
    val fecha: String,
    val horaEntrada: String,
    val horaSalida: String,
    val estado: String // Puede ser "Completado", "En curso", etc.
)
