package com.jonzarate.clydesdaledirectory.view.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jonzarate.clydesdaledirectory.R
import com.jonzarate.clydesdaledirectory.arch.Injection
import kotlinx.android.synthetic.main.fragment_people.*

class PeopleFragment : Fragment(), PeopleAdapter.OnUserClickListener {

    companion object {
        fun newInstance() : PeopleFragment {
            return PeopleFragment()
        }
    }

    private lateinit var viewmodel: PeopleViewModel
    private lateinit var adapter: PeopleAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_people, container, false)

        val factory = Injection.getPeopleViewModelFactory()
        viewmodel = ViewModelProviders.of(this, factory).get(PeopleViewModel::class.java)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTitle()
        setList()
        setObservers()
    }

    private fun setTitle() {
        toolbar.title = getString(R.string.tabs_people)
    }

    private fun setList() {
        adapter = PeopleAdapter(this)

        with (people) {
            val manager = LinearLayoutManager(requireContext())
            layoutManager = manager
            adapter = this@PeopleFragment.adapter
        }
    }

    private fun setObservers() {
        viewmodel.people.observe(this, Observer { people ->
            with (adapter) {
                this.people = people
                notifyDataSetChanged()
            }
        })

        viewmodel.launchPerson.observe(this, Observer {
            val action = PeopleFragmentDirections.actionDirectoryFragmentToPersonFragment(it)
            findNavController().navigate(action)
        })
    }

    override fun onUserClick(id: Int) {
        viewmodel.onPersonClicked(id)
    }
}