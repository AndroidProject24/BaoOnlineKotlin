package com.toan_itc.baoonline.di

import com.toan_itc.baoonline.viewmodel.RepoViewModel

import dagger.Subcomponent

@Subcomponent
interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): ViewModelSubComponent
    }

    // UserViewModel userViewModel();
    // SearchViewModel searchViewModel();
    fun repoViewModel(): RepoViewModel
}
