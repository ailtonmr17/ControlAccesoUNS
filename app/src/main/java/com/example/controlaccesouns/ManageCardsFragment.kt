import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.controlaccesouns.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ManageCardsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fabAddCard: FloatingActionButton
    private val userCards = mutableListOf(
        UserCard("Juan Pérez", "12345678"),
        UserCard("María García", "87654321")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_manage_cards, container, false)

        // Configuración del RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewUsers)
        fabAddCard = view.findViewById(R.id.fabAddCard)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = UserCardsAdapter(userCards, onEditCard = { userCard ->
            Toast.makeText(requireContext(), "Editar tarjeta de ${userCard.userName}", Toast.LENGTH_SHORT).show()
            // Aquí puedes abrir un formulario de edición
        }, onDeleteCard = { userCard ->
            userCards.remove(userCard)
            recyclerView.adapter?.notifyDataSetChanged()
            Toast.makeText(requireContext(), "Tarjeta eliminada", Toast.LENGTH_SHORT).show()
        })

        // Acción del botón para agregar tarjeta
        fabAddCard.setOnClickListener {
            Toast.makeText(requireContext(), "Agregar nueva tarjeta", Toast.LENGTH_SHORT).show()
            // Aquí puedes abrir un formulario para agregar una nueva tarjeta
        }

        return view
    }
}
