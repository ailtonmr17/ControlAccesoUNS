import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.controlaccesouns.R
import com.google.android.material.button.MaterialButton

class ReportsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var spinnerFilter: Spinner
    private lateinit var layoutDynamicFilters: LinearLayout
    private lateinit var btnGenerateReport: MaterialButton
    private lateinit var btnExportReport: MaterialButton
    private val reportItems = mutableListOf<ReportItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reports, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewReportPreview)
        spinnerFilter = view.findViewById(R.id.spinnerFilter)
        layoutDynamicFilters = view.findViewById(R.id.layoutDynamicFilters)
        btnGenerateReport = view.findViewById(R.id.btnGenerateReport)
        btnExportReport = view.findViewById(R.id.btnExportReport)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ReportPreviewAdapter(reportItems)

        // Manejar selección del filtro
        spinnerFilter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                updateFilterInputs(spinnerFilter.selectedItem.toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btnGenerateReport.setOnClickListener { generateReport() }
        btnExportReport.setOnClickListener { exportReport() }

        return view
    }

    private fun updateFilterInputs(filter: String) {
        layoutDynamicFilters.removeAllViews()

        when (filter) {
            "Fecha" -> {
                val editText = EditText(requireContext())
                editText.hint = "Ingrese la Fecha (YYYY-MM-DD)"
                layoutDynamicFilters.addView(editText)
            }
            "Laboratorio" -> {
                val editText = EditText(requireContext())
                editText.hint = "Ingrese el Laboratorio"
                layoutDynamicFilters.addView(editText)
            }
            "Docente" -> {
                val editText = EditText(requireContext())
                editText.hint = "Ingrese el Docente"
                layoutDynamicFilters.addView(editText)
            }
            "Curso" -> {
                val editText = EditText(requireContext())
                editText.hint = "Ingrese el Curso"
                layoutDynamicFilters.addView(editText)
            }
        }
    }

    private fun generateReport() {
        reportItems.clear()
        // Aquí debes agregar lógica para generar datos reales basados en los filtros
        reportItems.add(ReportItem("Lab 301", "Juan Pérez", "Aplicaciones Móviles", "2024-03-15", "08:00 - 10:00"))
        recyclerView.adapter?.notifyDataSetChanged()
        Toast.makeText(requireContext(), "Reporte generado", Toast.LENGTH_SHORT).show()
    }

    private fun exportReport() {
        Toast.makeText(requireContext(), "Exportando reporte en PDF/CSV", Toast.LENGTH_SHORT).show()
        // Aquí puedes implementar lógica para exportar el reporte a PDF o CSV
    }
}
