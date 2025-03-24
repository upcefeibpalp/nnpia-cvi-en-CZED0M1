// UserTable.tsx
import React from 'react';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Button, Paper } from '@mui/material';

interface UserTable {
    id: number;
    name: string;
    email: string;
    isActive: boolean;
}

interface UserTableProps {
    users: UserTable[];
    toggleActive: (id: number) => void;
}

const UserTable: React.FC<UserTableProps> = ({ users, toggleActive }) => (
    <TableContainer component={Paper}>
        <Table>
            <TableHead>
                <TableRow>
                    <TableCell>ID</TableCell>
                    <TableCell>Jméno</TableCell>
                    <TableCell>Email</TableCell>
                    <TableCell>Stav</TableCell>
                    <TableCell>Akce</TableCell>
                </TableRow>
            </TableHead>
            <TableBody>
                {users.map((user) => (
                    <TableRow key={user.id}>
                        <TableCell>{user.id}</TableCell>
                        <TableCell>{user.name}</TableCell>
                        <TableCell>{user.email}</TableCell>
                        <TableCell>{user.isActive ? 'Aktivní' : 'Neaktivní'}</TableCell>
                        <TableCell>
                            <Button
                                variant="contained"
                                color={user.isActive ? 'secondary' : 'primary'}
                                onClick={() => toggleActive(user.id)}
                            >
                                Změnit stav
                            </Button>
                        </TableCell>
                    </TableRow>
                ))}
            </TableBody>
        </Table>
    </TableContainer>
);

export default UserTable;
