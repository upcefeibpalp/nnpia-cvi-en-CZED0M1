// App.tsx
import { useState } from 'react';
import UserTable from './components/UserTable.tsx';

const App = () => {
    const [users, setUsers] = useState([
        { id: 1, name: 'Jan Novák', email: 'jan.novak@example.com', isActive: true },
        { id: 2, name: 'Petr Svoboda', email: 'petr.svoboda@example.com', isActive: false },
        { id: 3, name: 'Lucie Krejčová', email: 'lucie.krejcova@example.com', isActive: true },
    ]);

    const toggleActive = (id: number) => {
        setUsers((prevUsers) =>
            prevUsers.map((user) =>
                user.id === id ? { ...user, isActive: !user.isActive } : user
            )
        );
    };

    return (
        <div>
            <h1>Seznam uživatelů</h1>
            <UserTable users={users} toggleActive={toggleActive} />
        </div>
    );
};

export default App;
