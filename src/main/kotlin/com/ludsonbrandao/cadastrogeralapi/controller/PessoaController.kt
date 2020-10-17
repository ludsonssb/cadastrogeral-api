package com.ludsonbrandao.cadastrogeralapi.controller

import com.ludsonbrandao.cadastrogeralapi.model.CadastroPessoa
import com.ludsonbrandao.cadastrogeralapi.repository.PessoaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cadastropessoas")
class PessoaController {

    @Autowired
    lateinit var repository: PessoaRepository

    @PostMapping
    fun criar(@RequestBody cadastroPessoa: CadastroPessoa) = ResponseEntity.ok(repository.save(cadastroPessoa))

    @GetMapping
    fun buscar() = ResponseEntity.ok(repository.findAll())

    @PutMapping("{cpf}")
    fun alterar(@PathVariable cpf: String, @RequestBody cadastroPessoa: CadastroPessoa): ResponseEntity<CadastroPessoa>{
        val pessoa = repository.findByCpf(cpf)
        val salvarPessoa = pessoa.orElseThrow{RuntimeException("Cpf: $cpf não encontrado")}
                .copy(nome = pessoa.get().nome, email = pessoa.get().email)
        return ResponseEntity.ok(repository.save(salvarPessoa))
    }

    @DeleteMapping("{cpf}")
    fun deletar(@PathVariable cpf: String) = repository
            .findByCpf(cpf).ifPresent { repository.delete(it) }

}