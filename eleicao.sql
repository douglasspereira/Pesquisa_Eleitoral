-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 12-Ago-2022 às 04:01
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 8.1.6
CREATE DATABASE ELEICAO;
USE ELEICAO;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `ELEICAO`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `candidato`
--

CREATE TABLE `candidato` (
  `id` int(11) NOT NULL PRIMARY KEY,
  `nome` varchar(75) NOT NULL,
  `partido` varchar(75) NOT NULL,
  `ficha_limpa` char(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `candidato`
--

INSERT INTO `candidato` (`id`, `ficha_limpa`, `nome`, `partido`) VALUES
(1, 'SIM', 'CIRO GOMES', 'PDT'),
(2, 'SIM', 'FELIPE D AVILA', 'NOVO'),
(3, 'SIM', 'JAIR BOLSONARO', 'PL'),
(4, 'SIM', 'LEO PERICLES', 'UP'),
(5, 'NÃO', 'LULA', 'PT'),
(6, 'SIM', 'PABLO MARCAL', 'PROS'),
(7, 'SIM', 'SIMONE TEBET', 'MDB'),
(8, 'SIM', 'SOFIA MANZANO', 'PCB'),
(9, 'SIM', 'VERA', 'PSTU');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_pesquisa`
--

CREATE TABLE `tipo_pesquisa` (
  `id` int(11) NOT NULL PRIMARY KEY,
  `instituto` varchar(75) NOT NULL,
  `dt_pesquisa` datetime NOT NULL,
  `local` varchar(2) NOT NULL,
  `media_idade` int(3) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  `formato` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `tipo_pesquisa` (`id`, `instituto`, `dt_pesquisa`, `local`, `media_idade`, `tipo`, `formato`) VALUES
(1, 'DATAFOLHA', '0000-00-00 00:00:00', 'SC', 30, 'induzida', 'telefone'),
(2, 'QUAEST', '0000-00-00 00:00:00', 'SP', 20, 'livre', 'presencial');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pesquisa`
--

CREATE TABLE `pesquisa` (
  `id` int(11) NOT NULL,
  `candidato_id` int(11) NOT NULL,
  `tipo_pesquisa_id` int(11) NOT NULL,
  `votos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `pesquisa` (`id`, `votos`, `candidato_id`, `tipo_pesquisa_id`) VALUES
(1, 210, 1, 1),
(2, 33, 2, 1),
(3, 704, 3, 1),
(4, 22, 4, 1),
(5, 1012, 5, 1),
(6, 62, 6, 1),
(7, 84, 7, 1),
(8, 23, 8, 1),
(9, 50, 9, 1),
(10, 230, 1, 2),
(11, 41, 2, 2),
(12, 700, 3, 2),
(13, 33, 4, 2),
(14, 740, 5, 2),
(15, 72, 6, 2),
(16, 111, 7, 2),
(17, 25, 8, 2),
(18, 48, 9, 2);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tipo_pesquisa`
--

--
-- Índices para tabela `pesquisa`
--
ALTER TABLE `pesquisa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_pesquisa_candidato1_idx` (`candidato_id`),
  ADD KEY `FK_pesquisa_tipo_pesquisa1_idx` (`tipo_pesquisa_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `pesquisa`
--
ALTER TABLE `pesquisa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tipo_pesquisa`
--
ALTER TABLE `tipo_pesquisa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `pesquisa`
--
ALTER TABLE `pesquisa`
  ADD CONSTRAINT `FK_pesquisa_candidato1` FOREIGN KEY (`candidato_id`) REFERENCES `candidato` (`id`),
  ADD CONSTRAINT `FK_pesquisa_tipo_pesquisa1` FOREIGN KEY (`tipo_pesquisa_id`) REFERENCES `tipo_pesquisa` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
