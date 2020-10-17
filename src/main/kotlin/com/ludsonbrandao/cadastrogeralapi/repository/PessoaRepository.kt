package com.ludsonbrandao.cadastrogeralapi.repository

import com.ludsonbrandao.cadastrogeralapi.model.CadastroPessoa
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PessoaRepository: JpaRepository<CadastroPessoa, Long> {
    fun findByCpf(cpf: String): Optional<CadastroPessoa>

}