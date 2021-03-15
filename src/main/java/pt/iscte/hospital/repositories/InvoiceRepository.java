package pt.iscte.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.iscte.hospital.entities.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
