package facci.pm.retrofitkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewUsers: RecyclerView
    private lateinit var usersList : ArrayList<User>
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewUsers = findViewById(R.id.RecyclerViewUsers)
        recyclerViewUsers.setHasFixedSize(true)
        recyclerViewUsers.layoutManager = LinearLayoutManager(this)
        usersList = ArrayList()
        getUsers()
    }

    fun getUsers() {
        var retrofit = RetrofitClient.getInstance()
        var apiInterface = retrofit.create(ApiInterface::class.java)

        lifecycleScope.launchWhenCreated {

                val response = apiInterface.getUsers()
                if (response.isSuccessful()) {

                    usersList = response.body() as ArrayList<User>;
                    userAdapter = UserAdapter(usersList)
                    recyclerViewUsers.adapter = userAdapter

//                    if (usersList != null) {
//                        for (user in usersList){
//                            Log.e("id", user.id)
//                            Log.e("name", user.name)
//                            Log.e("username", user.username)
//                            Log.e("email", user.email)
//                        }
//                    }

                } else {
                    Toast.makeText(
                        this@MainActivity,
                        response.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
        }
    }
}