package com.example.footbalkt.presenter

import com.example.footbalkt.model.Team

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)

}