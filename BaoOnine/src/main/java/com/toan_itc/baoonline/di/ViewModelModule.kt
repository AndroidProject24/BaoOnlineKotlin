package com.toan_itc.baoonline.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

import com.toan_itc.baoonline.viewmodel.RepoViewModel
import com.toan_itc.baoonline.viewmodel.ViewModelFactory

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(RepoViewModel::class)
    internal abstract fun bindRepoViewModel(repoViewModel: RepoViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
