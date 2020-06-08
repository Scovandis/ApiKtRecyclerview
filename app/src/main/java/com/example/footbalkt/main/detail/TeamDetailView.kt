package com.example.footbalkt.main.detail

import com.example.footbalkt.model.Team

interface TeamDetailView {
    fun showLoading()
    fun hideLoading()
    fun showTeamDetail(data: List<Team>)
}