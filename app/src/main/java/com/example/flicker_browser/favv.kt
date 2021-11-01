package com.example.flicker_browser

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flicker_browser.db.imageDB
import com.example.flicker_browser.db.imageDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class favv : Fragment() {
    lateinit var rv: RecyclerView
    lateinit var db: imageDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v=inflater.inflate(R.layout.fragment_favv, container, false)
        setHasOptionsMenu(true)
        init(v)


        return v
    }

    fun init(v: View) {
        db= imageDB.getInstance(v.context).imageDao()
        image.imgarr.clear()
        rv=v.findViewById(R.id.rvm)
        rv.layoutManager= GridLayoutManager(v.context,2)
        CoroutineScope(Dispatchers.IO).launch {
            image.imgarr = db.getall() as ArrayList<image>
            activity?.runOnUiThread{rv.adapter = RVAdapter(image.imgarr, this@favv)}
        }
//        rv.layoutManager= LinearLayoutManager(this)
    }
    /////////////////////menu////////////////////////////


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)

    }

    override fun onPrepareOptionsMenu(menu: Menu) {

        val item1 = menu!!.getItem(0)
        item1.setTitle("switch to Main search")


        return super.onPrepareOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.m1 -> {
                //switchro to main
                Navigation.findNavController(requireView()).navigate(R.id.action_favv_to_main)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}