package br.ufpb.care.register

import br.ufpb.care.R

private val dependente = UserKind(R.string.dependente, R.string.dependente_descricao, R.drawable.ic_launcher_background)
private val exDependente = UserKind(R.string.ex_dependente, R.string.ex_dependente_descricao, R.drawable.ic_launcher_background)


class UserKindsImpl : UserKinds {
    override val value: List<UserKind> = listOf(

    )
}