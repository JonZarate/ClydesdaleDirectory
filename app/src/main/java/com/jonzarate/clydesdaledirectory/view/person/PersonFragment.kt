package com.jonzarate.clydesdaledirectory.view.person

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jonzarate.clydesdaledirectory.R
import com.jonzarate.clydesdaledirectory.arch.Injection
import com.jonzarate.clydesdaledirectory.arch.loadAvatar
import com.jonzarate.clydesdaledirectory.data.model.Person
import kotlinx.android.synthetic.main.fragment_person.*

class PersonFragment : Fragment() {

    companion object {

        private const val EXTRA_ID = "id"

        fun newInstance(id: Int) : PersonFragment {
            return PersonFragment().apply {
                arguments = Bundle().apply {
                    putInt(EXTRA_ID, id)
                }
            }
        }
    }

    private lateinit var viewmodel: PersonViewModel
    private lateinit var adapter: PersonAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_person, container, false)

        val id = arguments?.getInt(EXTRA_ID) ?: 0

        val factory = Injection.getPersonViewModelFactory(id)
        viewmodel = ViewModelProviders.of(this, factory).get(PersonViewModel::class.java)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBackArrow()
        setList()
        setObservers()
    }

    private fun setBackArrow() {
        (requireActivity() as? AppCompatActivity)?.also {
            it.setSupportActionBar(toolbar)
            it.supportActionBar?.setDisplayHomeAsUpEnabled(true)

            /*
                This little hack makes sure the new title is used when we set it later
             */

            it.title = ""
        }
    }

    private fun setTitle(person: Person) {
        loadAvatar(toolbar_image, person.avatar)
        (requireActivity() as? AppCompatActivity)?.title = getString(
                R.string.person_full_name,
                person.firstName,
                person.lastName
            )
    }

    private fun setList() {
        adapter = PersonAdapter()

        with(person_details) {
            val manager = LinearLayoutManager(requireContext())
            layoutManager = manager
            adapter = this@PersonFragment.adapter
        }
    }

    private fun setObservers() {
        viewmodel.person.observe(this, Observer { person ->
            setTitle(person)
            with (adapter) {
                this.person = person
                notifyDataSetChanged()
            }

        })
    }
}