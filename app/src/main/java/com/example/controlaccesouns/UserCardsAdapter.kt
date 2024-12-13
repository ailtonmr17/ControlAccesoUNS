import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.controlaccesouns.R

data class UserCard(val userName: String, val cardId: String)

class UserCardsAdapter(
    private val userCards: List<UserCard>,
    private val onEditCard: (UserCard) -> Unit,
    private val onDeleteCard: (UserCard) -> Unit
) : RecyclerView.Adapter<UserCardsAdapter.UserCardViewHolder>() {

    class UserCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userName: TextView = itemView.findViewById(R.id.textUserName)
        val cardId: TextView = itemView.findViewById(R.id.textCardId)
        val editButton: Button = itemView.findViewById(R.id.btnEditCard)
        val deleteButton: Button = itemView.findViewById(R.id.btnDeleteCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserCardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user_card, parent, false)
        return UserCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserCardViewHolder, position: Int) {
        val userCard = userCards[position]
        holder.userName.text = "Usuario: ${userCard.userName}"
        holder.cardId.text = "Tarjeta NFC: ${userCard.cardId}"

        holder.editButton.setOnClickListener { onEditCard(userCard) }
        holder.deleteButton.setOnClickListener { onDeleteCard(userCard) }
    }

    override fun getItemCount(): Int = userCards.size
}
