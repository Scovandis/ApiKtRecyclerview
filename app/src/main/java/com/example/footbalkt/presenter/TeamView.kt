package com.example.footbalkt.presenter

import com.example.footbalkt.model.Team

interface TeamView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)

}