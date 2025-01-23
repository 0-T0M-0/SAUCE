// Importation des modules nécessaires
import { Chart, BarController, BarElement, PieController, ArcElement, CategoryScale, LinearScale, Tooltip, Legend } from 'chart.js';
import { expensesByCategory, months } from './data';

// Enregistre les composants nécessaires pour les graphiques
Chart.register(BarController, BarElement, PieController, ArcElement, CategoryScale, LinearScale, Tooltip, Legend);

// Prépare les données pour le graphique en barres
const categories = Object.keys(expensesByCategory);
const datasets = categories.map((category) => ({
    label: category,
    data: expensesByCategory[category],
    backgroundColor: getRandomColor(),
}));

// Fonction pour générer des couleurs aléatoires
function getRandomColor() {
    const r = Math.floor(Math.random() * 255);
    const g = Math.floor(Math.random() * 255);
    const b = Math.floor(Math.random() * 255);
    return `rgba(${r}, ${g}, ${b}, 0.5)`;
}

// Crée le graphique en barres
const barCtx = document.getElementById('myBarChart').getContext('2d');
const myBarChart = new Chart(barCtx, {
    type: 'bar',
    data: {
        labels: months,
        datasets: datasets,
    },
    options: {
        responsive: true,
        plugins: {
            legend: {
                position: 'top',
            },
            tooltip: {
                mode: 'index',
                intersect: false,
            },
        },
        scales: {
            x: {
                title: {
                    display: true,
                    text: 'Months',
                },
            },
            y: {
                beginAtZero: true,
                title: {
                    display: true,
                    text: 'Expenses (€)',
                },
            },
        },
    },
});

// Prépare les données pour le graphique en camembert
const totalExpensesByCategory = categories.map((category) =>
expensesByCategory[category].reduce((sum, expense) => sum + expense, 0)
);

// Crée le graphique en camembert
const pieCtx = document.getElementById('myPieChart').getContext('2d');
const myPieChart = new Chart(pieCtx, {
    type: 'pie',
    data: {
        labels: categories,
        datasets: [
            {
                data: totalExpensesByCategory,
                backgroundColor: categories.map(() => getRandomColor()),
            },
        ],
    },
    options: {
        responsive: true,
        plugins: {
            legend: {
                position: 'top',
            },
            tooltip: {
                callbacks: {
                    label: function (context) {
                        const value = context.raw;
                        const total = totalExpensesByCategory.reduce((sum, expense) => sum + expense, 0);
                        const percentage = ((value / total) * 100).toFixed(2);
                        return `${context.label}: ${value}€ (${percentage}%)`;
                    },
                },
            },
        },
    },

});
