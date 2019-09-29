package com.jonzarate.clydesdaledirectory.view.room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jonzarate.clydesdaledirectory.R
import com.jonzarate.clydesdaledirectory.arch.Injection
import kotlinx.android.synthetic.main.fragment_rooms.*

class RoomsFragment : Fragment() {

    companion object {

        fun newInstance(): RoomsFragment {
            return RoomsFragment()
        }
    }

    private lateinit var viewmodel: RoomsViewModel
    private lateinit var adapter: RoomsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_rooms, container, false)

        val factory = Injection.getRoomsViewModelFactory()
        viewmodel = ViewModelProviders.of(this, factory).get(RoomsViewModel::class.java)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTitle()
        setList()
        setObservers()
    }

    private fun setTitle() {
        toolbar.title = getString(R.string.tabs_rooms)
    }

    private fun setList() {
        adapter = RoomsAdapter()

        with (rooms) {
            val manager = LinearLayoutManager(requireContext())
            layoutManager = manager
            adapter = this@RoomsFragment.adapter
        }
    }

    private fun setObservers() {
        viewmodel.rooms.observe(this, Observer { rooms ->
            with (adapter) {
                this.rooms = rooms
                notifyDataSetChanged()
            }
        })
    }
}