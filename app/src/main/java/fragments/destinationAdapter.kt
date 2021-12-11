package fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basicnavigation.databinding.ItemUserBinding
import com.example.basicnavigation.database.User

class destinationAdapter (private val users: List<User>,private val callBack: UserListCallback): RecyclerView.Adapter<destinationAdapter.DestinationHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DestinationHolder(binding,callBack)
    }

    override fun onBindViewHolder(holder: DestinationHolder, position: Int) {
        holder.render(users[position])
    }
    override fun getItemCount(): Int = users.size

    class DestinationHolder(val binding: ItemUserBinding,val callBack: UserListCallback):RecyclerView.ViewHolder (binding.root){
        fun render(user: User) {
            binding.id.setText(user.id.toString())
            binding.name.setText(user.name)
            binding.tipo.setText(user.tipo)
            binding.hp.setText(user.hp)
            binding.attack.setText(user.attack)
            binding.special.setText(user.special)
            binding.deffense.setText(user.defense)
            binding.ds.setText(user.defense_special)
            binding.speed.setText(user.speed)
            binding.weight.setText(user.weight)
            /////callback
           /* binding.delete.setOnClickListener {
                callBack.onClick(user)
            }

            */
        }
    }

}