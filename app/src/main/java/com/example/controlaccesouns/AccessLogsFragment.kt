import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.controlaccesouns.R

class AccessLogsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_access_logs, container, false)

        // Lista de registros (puedes reemplazarla por datos dinámicos)
        val accessLogs = listOf(
            AccessLog("001", "Juan Pérez", "Lab 301", "Aplicaciones Móviles", "2024-03-15", "08:00", "11:00", "Completado"),
            AccessLog("002", "María García", "Lab 302", "Base de Datos", "2024-03-15", "11:00", "14:00", "Completado"),
            AccessLog("003", "Carlos López", "Lab 303", "Desarrollo Web", "2024-03-15", "14:00", "--:--", "En curso")
        )

        // Configurar RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewAccessLogs)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = AccessLogsAdapter(accessLogs)

        return view
    }
}
