function aplicarMask() {
    $('.placa').mask('AAA-0000');
    $('.cpf').mask('000.000.000-00');
    $('.celular').mask('(00)00000-0000');
    $('.telefone').mask('(00)0000-0000');
    $('.moeda').mask('000.000.000.000.000,00', {reverse: true});
    $('.date').mask('00/00/0000');
}