package br.ufpb.care.register

import br.ufpb.care.R

class UserKindsImpl : UserKinds {
    private val dependent = UserKind(name = R.string.dependent, description = R.string.dependent_description, icon = R.drawable.dependent)
    private val codependent = UserKind(name = R.string.codependent, description = R.string.codependent_description, icon = R.drawable.codependent)
    private val exDependent = UserKind(name = R.string.ex_dependent, description = R.string.ex_dependent_description, icon = R.drawable.ex_dependent)
    private val specialist =  UserKind(name = R.string.specialist, description =  R.string.specialist_description, icon = R.drawable.specialist)
    private val communicator = UserKind(name = R.string.communicator, description = R.string.communicator_description, icon = R.drawable.communicator)

    override val value: List<UserKind> = listOf(dependent, codependent, exDependent, specialist, communicator)
}