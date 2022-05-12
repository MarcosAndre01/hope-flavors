import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.ufpb.care.R
import br.ufpb.care.databinding.UserKindItemBinding
import br.ufpb.care.register.UserKind

class UserKindAdapter : RecyclerView.Adapter<UserKindAdapter.UserKindViewHolder>() {
    class UserKindViewHolder(val binding: UserKindItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<UserKind>() {
        override fun areItemsTheSame(oldItem: UserKind, newItem: UserKind): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: UserKind, newItem: UserKind): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var userKinds: List<UserKind>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserKindViewHolder(
        UserKindItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: UserKindAdapter.UserKindViewHolder, position: Int) {
        val kind = userKinds[position]
        val context = holder.itemView.context

        holder.binding.apply {
            title.text = context.getString(kind.name)
            subtitle.text = context.getString(kind.description)
            icon.setImageResource(kind.icon)
        }
    }

    override fun getItemCount(): Int {
        return userKinds.size
    }
}
