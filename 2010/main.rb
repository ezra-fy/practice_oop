require_relative 'tax_payer'

person = 0
IO.foreach('taxpayer.dat') do |line|
  data = line.split
  name = data[0]
  salary = data[1]
  credit = data[2]
  person = TaxPayer.new(name, salary, credit)
end

puts person.to_s
