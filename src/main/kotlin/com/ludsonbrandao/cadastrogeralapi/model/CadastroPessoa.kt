package com.ludsonbrandao.cadastrogeralapi.model

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "pessoas")
data class CadastroPessoa(
        @field:Id
        @field:GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        val nome: String,
        val cpf: String,
        @Column(columnDefinition = "DATE")
        val dataNascimento: LocalDate,
        val email: String
)