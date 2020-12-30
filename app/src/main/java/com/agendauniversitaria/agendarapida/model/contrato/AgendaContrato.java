package com.agendauniversitaria.agendarapida.model.contrato;

import android.provider.BaseColumns;

public final class AgendaContrato {

    public AgendaContrato() {}

    public static final class TabelaDisciplina implements BaseColumns{

        public static final String NOME_TABELA = "disciplina";

        public static final String ID = "id";
        public static final String NOME_DISC = "nomedisc";
        public static final String NOME_PROF = "nomeprof";
        public static final String SALA = "sala";
        public static final String DESCRICAO = "descricao";
    }
    public static final class TabelaLembrete implements BaseColumns{

        public static final String NOME_TABELA = "lembrete";

        public static final String ID = "id";
        public static final String NOME_LEMBR = "nomelembr";
        public static final String DESCRICAO = "descricao";
        public static final String HORA_ALARME = "hoaralarme";

    }

}
