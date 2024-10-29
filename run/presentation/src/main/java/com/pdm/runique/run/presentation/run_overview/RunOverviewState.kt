package com.pdm.runique.run.presentation.run_overview

import com.pdm.runique.run.presentation.run_overview.model.RunUi

data class RunOverviewState(
    val runs: List<RunUi> = emptyList()
)
